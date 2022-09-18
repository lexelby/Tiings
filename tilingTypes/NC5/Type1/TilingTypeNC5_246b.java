package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_246b
   extends TilingType
{
   public TilingTypeNC5_246b(){
      super( "NC5-246b", 5, SymmetryType.pg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 40};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {1, 1,4, 1,4,1, 0},
            {2, 3,4, 0,1,2, 1},
            {0, 1,0, 3,0,1, 1},
            {1, 1,4, 4,4,1, 1},
      };
      info = "b=a+d\nc=e\nB+C=180\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 1.2;
      double ln1 = ln * getParam(paramValues, 1)/100;
      double a = getParam(paramValues, 0);
      double s = ln1 * Math.sin(a*DEG2RAD);
      double c = ln1 * Math.cos(a*DEG2RAD);
      double w = (ln1-c)/2;
      
      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1, ln, 0);
      baseTile.setPoint(2, ln-w, s/2);
      baseTile.setPoint(3, c+w, s/2);
      baseTile.setPoint(4, c, s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[3].getX(2);
      offsets[1] = tiles[0].getY(4)-tiles[3].getY(2);
      offsets[2] = tiles[2].getX(1)-tiles[5].getX(0);
      offsets[3] = tiles[2].getY(1)-tiles[5].getY(0);
   }
}
