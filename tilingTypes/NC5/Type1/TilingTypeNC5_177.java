package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_177
   extends TilingType
{
   public TilingTypeNC5_177(){
      super( "NC5-177", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,3,4, 1},
            {1, 0,3, 1,3,0, 1},
            {0, 3,4, 2,4,0, 0},

            {0, 2,3, 0,0,1, 1},
            {1, 4,0, 4,3,4, 0},
            {1, 0,3, 5,3,0, 0},
            {0, 3,4, 6,4,0, 1},
      };
      info = "a=e\nb=d\nA+C=180\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnae = 1.0;
      double a = getParam(paramValues,0);
      double w = lnae * Math.sin(a/2 * DEG2RAD);

      double lnc = w*2 * getParam(paramValues,1)/100;
      
      double h = Math.sqrt(lnae*lnae-w*w);
      double alpha = Math.atan2(h*lnc, w*(2*lnae+lnc))/DEG2RAD;
      double ang = 90-a/2 - 2*alpha;

      double dx = lnc/2 * Math.cos(ang * DEG2RAD);
      double dy = lnc/2 * Math.sin(ang * DEG2RAD);
      
      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  w-dx, dy);
      baseTile.setPoint(2,  w+dx, -dy);
      baseTile.setPoint(3,  w*2, 0);
      baseTile.setPoint(4,  w, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[4].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[4].getY(0);
      offsets[2] = tiles[3].getX(2)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(2)-tiles[7].getY(0);
   }
}
