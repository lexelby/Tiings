package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_208a
   extends TilingType
{
   public TilingTypeNC5_208a(){
      super( "NC5-208a", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{ 70, 30, 70};
      paramName = new String[]{ "Angle", "Indent", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,1,2, 1},
            {1, 4,0, 1,3,4, 0},
            {0, 1,2, 2,2,3, 1},

            {0, 4,3, 0,3,4, 0},
            {1, 2,3, 4,1,2, 1},
            {1, 4,0, 5,3,4, 0},
            {0, 1,2, 6,2,3, 1},
      };
      info = "a=e\nc=b+d\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = 0.8;
      double a = getParam(paramValues,0);
      
      double w = lna * Math.sin(a/2 * DEG2RAD);
      double h = lna * Math.cos(a/2 * DEG2RAD);

      double ind = h * (getParam(paramValues,1)/50 -1);
      double k = ind/w;
      double w1 = w * getParam(paramValues,2)/100;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  w1, w1*k);
      baseTile.setPoint(2,  w1+w, (w1-w)*k);
      baseTile.setPoint(3,  w+w, 0);
      baseTile.setPoint(4,  w, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[0].getX(3);
      offsets[1] = tiles[0].getY(0)-tiles[0].getY(3);
      offsets[2] = tiles[3].getX(4)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(4)-tiles[7].getY(0);
   }
}
