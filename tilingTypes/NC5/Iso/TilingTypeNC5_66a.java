package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_66a
   extends TilingType
{
   public TilingTypeNC5_66a(){
      super( "NC5-66a", 5, SymmetryType.pg );

      paramMin = new int[]{   0,  0,  0};
      paramMax = new int[]{  90,100,100};
      paramDef = new int[]{  30, 50, 50};
      paramName = new String[]{ "Angle", "Aspect", "Indentation" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,2,3, 1},
      };
      info = "b=d\nc=a+e\nB+D=360\n(A+C+E=180)\n(A+B=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.5 * paramValues[1]/100;
      double w = 1.5 - h;
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
      offsets[2] = tiles[1].getX(3)-tiles[0].getX(1);
      offsets[3] = tiles[1].getY(3)-tiles[0].getY(1);
   }
}
