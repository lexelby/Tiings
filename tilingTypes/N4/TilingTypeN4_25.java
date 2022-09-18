package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_25
   extends TilingType
{
   public TilingTypeN4_25(){
      super( "N4-25", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 50, 70, 30};
      paramName = new String[]{ "Relative Length", "Relative Length", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,1,2, 1},
            {0, 2,3, 1,0,1, 0},
            {1, 3,0, 2,1,2, 1},
      };
      info = "A+C=180\n(B+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln12 = 3 * getParam( paramValues,0)/100.;
      double ln34 = 3 - ln12;
      double ln1 = ln12 * getParam( paramValues,1)/100.;
      double ln2 = ln12 - ln1;
      double ln3 = ln34 * getParam( paramValues,2)/100.;
      double ln4 = ln34 - ln3;
      
      double b = Math.acos((ln1*ln1+ln2*ln2-ln3*ln3-ln4*ln4)/(2*ln1*ln2+2*ln3*ln4));
      double c = Math.acos((ln2*ln2+ln3*ln3-ln4*ln4-ln1*ln1)/(2*ln2*ln3+2*ln4*ln1));
      double x2 = ln2-ln1*Math.cos(b);
      double y2 =     ln1*Math.sin(b);
      double x3 = ln3*Math.cos(c);
      double y3 = ln3*Math.sin(c);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln2,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(0)-tiles[1].getX(2);
      offsets[1] = tiles[2].getY(0)-tiles[1].getY(2);
      offsets[2] = tiles[2].getX(3)-tiles[3].getX(1);
      offsets[3] = tiles[2].getY(3)-tiles[3].getY(1);
   }
}
