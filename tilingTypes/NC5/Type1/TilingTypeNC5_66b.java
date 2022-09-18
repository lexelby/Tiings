package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_66b
   extends TilingType
{
   public TilingTypeNC5_66b(){
      super( "NC5-66b", 5, SymmetryType.pg );

      paramMin = new int[]{   0,  0,  0};
      paramMax = new int[]{  90,100,100};
      paramDef = new int[]{  30, 50, 50};
      paramName = new String[]{ "Angle", "Aspect", "Indentation" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,2,3, 1},

            {0, 1,0, 0,0,1, 0},
            {1, 0,1, 2,2,3, 1},
      };
      info = "b=d\nc=a+e\nA+B=180\nB+D=360\n(A+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.3;
      double h = lnt * paramValues[1]/100;
      double w = lnt - h;
      double t = Math.tan( paramValues[0] * DEG2RAD);
      double offset = h * t;
      double iw = w/2 * paramValues[2]/100;
      double ih = iw/t;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, w-iw, -ih);
      baseTile.setPoint(2, w+offset, h);
      baseTile.setPoint(3, offset+iw, h-ih);
      baseTile.setPoint(4,  offset, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[1].getX(3)-tiles[3].getX(2);
      offsets[3] = tiles[1].getY(3)-tiles[3].getY(2);
   }
}
